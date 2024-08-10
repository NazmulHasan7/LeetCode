// 1472. Design Browser History
package Medium;

public class Medium_1472_Design_Browser_History {
    static class DoublyLinkedList {
        String homepage;
        DoublyLinkedList prev, next;
        public DoublyLinkedList(String homepage) {
            this.homepage = homepage;
            prev = next = null;
        }
    }
    static class BrowserHistory {
        DoublyLinkedList node;
        public BrowserHistory(String homepage) {
            node = new DoublyLinkedList(homepage);
        }
        public void visit(String url) {
            DoublyLinkedList newNode = new DoublyLinkedList(url);
            newNode.prev = node;
            node.next = newNode;
            node = newNode;
        }
        public String back(int steps) {
            while (node.prev != null && steps-- > 0)
                node = node.prev;
            return node.homepage;
        }
        public String forward(int steps) {
            while (node.next != null && steps-- > 0)
                node = node.next;
            return node.homepage;
        }
    }
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        browserHistory.back(1);
        browserHistory.back(1);
        browserHistory.forward(1);
        browserHistory.visit("linkedin.com");
        browserHistory.forward(2);
        browserHistory.back(2);
        browserHistory.back(7);
    }
}
