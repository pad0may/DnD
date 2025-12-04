import java.util.ArrayList;
import java.util.List;

/**
 * Represents a directory in the file system tree. A directory can contain other directories and
 * files as children.
 */
public class FolderNode extends FileSystemNode {

    private List<FileSystemNode> children;

    public FolderNode(String name, FolderNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    @Override
    public boolean isFolder() {
        return true;
    }

    /**
     * Returns a list view of the children contained directly inside this directory. Modifying the
     * returned list is not required to be supported.
     */
    public List<FileSystemNode> getChildren() {
        return children;
    }

    /**
     * Searches the children of this directory for a node whose name matches the input. Only direct
     * children are considered, not deeper descendants.
     */
    public FileSystemNode getChildByName(String childName) {
        for (FileSystemNode child : children) {
            if (child.getName().equals(childName)) {
                return child;
            }
        }
        return null;

    }

    /**
     * Creates a new file directly inside this directory with the given name and size. If a child
     * with the same name already exists, no file is created and false is returned. Otherwise the
     * new file is added and true is returned.
     */
    public boolean addFile(String fileName, int size) {
        if (getChildByName(fileName) != null) return false;
        FileNode newFile = new FileNode(this, fileName, size);
        children.add(newFile);
        return true;
    }

    /**
     * Creates a new subdirectory directly inside this directory with the given name. If a child
     * with the same name already exists, no folder is created and false is returned. Otherwise the
     * new folder is added and true is returned.
     */
    public boolean addFolder(String folderName) {
        if (getChildByName(folderName) != null) {
            return false;
        }
        FolderNode newFolder = new FolderNode(folderName, this);
        children.add(newFolder);
        return true;
    }

    /**
     * Searches this directory and all of its descendants for nodes whose name matches the input.
     * When a match is found, its full path can be printed by the caller using toString().
     */
    public boolean containsNameRecursive(String searchName) {
        if (children.size() == 0) return false;
        for (FileSystemNode child : children) {
            if (getChildByName(searchName) != null) {
                return true;
            }
            if (child.isFolder()) {
                FolderNode temp = (FolderNode) child;
                temp.containsNameRecursive(searchName);
            }
        }
    }

    @Override
    public int getHeight() {
        int height = 0;
        FileSystemNode temp = this;
    }

    private int heightGet(int count) {
        int folderCount = 0;
        for (FileSystemNode child : children) {
            if (child.isFolder()) folderCount++;
        }
        if (folderCount == 0) return count;
        for (FileSystemNode child : children) {
            
        }
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemNode child : children) {
            size += child.getSize();
            }
        return size;
    }

    @Override
    public int getTotalNodeCount() {
        // TODO: count this directory plus all descendant files and folders
        return 0;
    }
}
