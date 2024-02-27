package org.example;


class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String key, ContactInfo contact) {
        root = insertRec(root, key, contact);
    }

    private TreeNode insertRec(TreeNode root, String key, ContactInfo contact) {
        if (root == null) {
            return new TreeNode(key, contact);
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, contact);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, contact);
        }

        return root;
    }

    public ContactInfo search(String key) {
        return searchRec(root, key);
    }

    private ContactInfo searchRec(TreeNode root, String key) {
        if (root == null || key.equals(root.key)) {
            return (root != null) ? root.contact : null;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void remove(String key) {
        root = removeRec(root, key);
    }

    private TreeNode removeRec(TreeNode root, String key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = removeRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = removeRec(root.right, key);
        } else {
            // Eğer key bulunduysa
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // İki çocuğu olan düğümü silme
            root.key = minValue(root.right);
            root.right = removeRec(root.right, root.key);
        }

        return root;
    }
    private String minValue(TreeNode root) {
        String minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }
}