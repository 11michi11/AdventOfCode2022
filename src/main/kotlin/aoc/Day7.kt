package aoc

import readInputWhole

class Day7 {

    fun part1(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }.filter { it != "\$ cd /" }


        val tree = Tree.parse(parts)
        val dirs = mutableListOf<Dir>()

        tree.traverse(tree.root, dirs)
        return dirs.filter { it.getSize() <= 100000 }.sumOf { it.getSize() }
    }


    fun part2(filename: String): Int {
        val input = readInputWhole(filename)
        val parts = input.split("\n").filter { it.isNotEmpty() }.filter { it != "\$ cd /" }

        val tree = Tree.parse(parts)
        val dirs = mutableListOf<Dir>()

        tree.traverse(tree.root, dirs)


        dirs.sortBy { it.getSize() }

        dirs.forEach { dir ->
            tree.removeDir(dir)
            if (tree.root.getSize() < 40000000) {
                dir.reAddItem()
                return dir.getSize()
            }
            dir.reAddItem()
        }

        return 1
    }
}

abstract class TreeNode(val name: String, val parent: TreeNode?) {

    abstract fun getSize(): Int

}

class File(private val size: Int, name: String, parent: TreeNode?) : TreeNode(name, parent) {
    override fun getSize(): Int {
        return size
    }
}

class Dir(name: String, parent: TreeNode?) : TreeNode(name, parent) {

    private val items = mutableListOf<TreeNode>()
    private var shouldBeCounted = true
    override fun getSize(): Int {
        return if (shouldBeCounted) {
            items.sumOf { it.getSize() }
        } else {
            0
        }
    }

    fun addItem(item: TreeNode) {
        items.add(item)
    }

    fun removeItem(item: TreeNode) {
        val removed = items.firstOrNull { it == item }

        if (removed == null) {
            items.forEach { if (it is Dir) it.removeItem(item) }
        } else {
            (removed as Dir).shouldBeCounted = false
        }
    }

    fun reAddItem() {
        shouldBeCounted = true
    }

    fun getDirByName(name: String): Dir {
        return items.first { it.name == name } as Dir
    }

    fun getSubDirs(): List<Dir> {
        return items.filterIsInstance<Dir>()
    }

}

class Tree() {
    val root: Dir = Dir("/", null)

    fun traverse(treeNode: TreeNode, dirs: MutableList<Dir>) {
        if (treeNode is File) {
            return
        }

        val dir = treeNode as Dir
        dirs.add(dir)

        dir.getSubDirs().forEach { traverse(it, dirs) }
    }

    fun removeDir(dir: Dir) {
        root.removeItem(dir)
    }

    companion object {

        fun parse(parts: List<String>): Tree {
            val tree = Tree()

            var currentDir = tree.root

            for (line in parts) {

                if (line == "\$ ls") {
                    // Just printing content, nothing to do here
                    continue
                } else if (line.startsWith("\$ cd")) {
                    // Change current node to X
                    val newDirName = line.replace("\$ cd ", "")
                    currentDir = if (newDirName == "..") {
                        // Go up
                        currentDir.parent as Dir
                    } else {
                        // Go down
                        currentDir.getDirByName(newDirName)
                    }
                } else if (line.startsWith("dir")) {
                    // Create a sub dir
                    val newDirName = line.replace("dir ", "")
                    currentDir.addItem(Dir(newDirName, currentDir))
                } else {
                    // Add a file to current dir
                    val (size, name) = line.split(" ")
                    currentDir.addItem(File(Integer.parseInt(size), name, currentDir))
                }

            }
            return tree
        }
    }

}
