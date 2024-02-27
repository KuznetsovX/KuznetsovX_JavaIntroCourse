package com.kuznetsov.homework10;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree implements IStringSet, ISortedStringSet, Iterable<String> {

    int length;
    TreeNode root;

    @Override
    public ISortedStringSet subset(String from, String upTo) {
        return null;
    }

    @Override
    public String leftmost() {
        TreeNode current = root;
        while (true) {
            if (current.left == null) return current.val;

            current = current.left;
        }
    }

    @Override
    public String rightmost() {
        TreeNode current = root;
        while (true) {
            if (current.right != null) {
                current = current.right;
            } else {
                return current.val;
            }
        }
    }

    @Override
    public int len() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(String val) {
        if (isEmpty()) return false;

        TreeNode current = root;
        while (true) {
            int compareResult = compare(val, current.val);
            if (compareResult == 0) {
                return true;
            }
            if (compareResult > 0) {
                if (current.right == null) {
                    return false;
                } else {
                    current = current.right;
                }
            }
            if (compareResult < 0) {
                if (current.left == null) {
                    return false;
                } else {
                    current = current.left;
                }
            }

        }
    }

    @Override
    public boolean add(String val) {
        TreeNode toAdd = new TreeNode();
        toAdd.val = val;
        TreeNode current = root;
        while (true) {
            if (isEmpty()) {
                root = new TreeNode();
                root.val = val;
                length++;
                return true;
            }
            int compareResult = compare(toAdd.val, current.val);
            if (compareResult == 0) {
                return false;
            }
            if (compareResult > 0) {
                if (current.right == null) {
                    current.right = toAdd;
                    length++;
                    return true;
                } else {
                    current = current.right;
                }
            }
            if (compareResult < 0) {
                if (current.left == null) {
                    current.left = toAdd;
                    length++;
                    return true;
                } else {
                    current = current.left;
                }
            }
        }

    }

    @Override
    public boolean remove(String val) {
        TreeNode current = root;
        TreeNode parent = root;
        while (true) {
            int compareResult = compare(val, current.val);
            if (compareResult == 0) {
                if (current.left == null && current.right == null) {
                    if (parent.right == current) {
                        parent.right = null;
                    } else if (parent.left == current) {
                        parent.left = null;
                    }
                }
                if (current.left != null && current.right == null) {
                    if (parent.right == current) {
                        parent.right = current.left;
                    } else if (parent.left == current) {
                        parent.left = current.left;
                    }
                }
                if (current.left == null && current.right != null) {
                    if (parent.right == current) {
                        parent.right = current.right;
                    } else if (parent.left == current) {
                        parent.left = current.right;
                    }
                }
                if (current.left != null && current.right != null) {
                    TreeNode toReplace = current;
                    parent = current;
                    current = current.left;
                    while (current.right != null) {
                        parent = current;
                        current = current.right;
                    }
                    toReplace.val = current.val;
                    if (current.left != null) {
                        parent.right = current.left;
                    } else {
                        parent.right = null;
                    }
                }
                length--;
                return true;
            }
            if (compareResult > 0) {
                parent = current;
                current = current.right;
            }
            if (compareResult < 0) {
                current = current.left;
            }
        }
    }

    public int compare(String first, String second) {
        return String.CASE_INSENSITIVE_ORDER.compare(first, second);
    }

    @Override
    public Iterator<String> iterator() {
        return new BinaryTreeIterator(root);
    }

    public static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
    }

    private static class BinaryTreeIterator implements Iterator<String> {

        TreeNode root;
        TreeNode next;


        public BinaryTreeIterator(TreeNode root) {
            this.root = root;
            prepareNext();
        }

        private int compare(String first, String second) {
            return String.CASE_INSENSITIVE_ORDER.compare(first, second);
        }

        private void prepareNext() {
            if (next == null) {
                next = root;
                while (next.left != null) {
                    next = next.left;
                }
                return;
            }

            if (next.right != null) {
                next = next.right;
                while (next.left != null) {
                    next = next.left;
                }
            } else {
                TreeNode cur = root;
                while (true) {
                    int compare = compare(next.val, cur.val);
                    if (compare == 0) {
                        next = null;
                        break;
                    } else if (compare < 0) {
                        if (cur.left == next) {
                            next = cur;
                            break;
                        } else {
                            cur = cur.left;
                        }
                    } else {
                        if (cur.right == next) {
                            next = cur;
                            cur = root;
                        } else {
                            cur = cur.right;
                        }
                    }
                }
            }
        }


        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String next() {
            if (this.hasNext()) {
                String val = next.val;
                prepareNext();
                return val;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
