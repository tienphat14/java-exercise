package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListExcercise {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListExcercise.class);

    public static void main(String[] args) {
        TelevisionShowLinkedList list = new TelevisionShowLinkedListImpl();
        list.add(new TelevisionShow(10.0, Channel.VTV3, "test1"));
        list.add(new TelevisionShow(11.0, Channel.VTV3, "test2"));
        list.add(new TelevisionShow(12.0, Channel.VTV3, "test3"));
        list.add(new TelevisionShow(13.0, Channel.VTV3, "test4"));
        list.add(new TelevisionShow(14.0, Channel.VTV3, "test5"));
        printList(list);
        list.remove(1);
        list.remove(2);
        printList(list);
        TelevisionShow show = new TelevisionShow(100.0, Channel.HTV1, "testInsert");
        list.add(1, show);
        printList(list);
        LOGGER.info("Test insert show - contains:{} index:{}", list.contains(show), list.indexOf(show));
        list.remove(show);
        printList(list);
        LOGGER.info("Test remove show - contains:{} index:{}", list.contains(show), list.indexOf(show));
    }

    public static void printList(TelevisionShowLinkedList list) {
        LOGGER.info("**************************************************");
        for (int i = 0; i < list.size(); i++) {
            LOGGER.info("Index{}: {}", i, list.get(i).getName());
        }
    }

}
