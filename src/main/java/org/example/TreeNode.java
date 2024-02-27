package org.example;

class TreeNode {
    String key;
    ContactInfo contact;
    TreeNode left, right;

    public TreeNode(String key, ContactInfo contact) {
        this.key = key;
        this.contact = contact;
        this.left = this.right = null;
    }
}