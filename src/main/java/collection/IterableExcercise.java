package collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IterableExcercise {

    private static final Logger LOGGER = LoggerFactory.getLogger(IterableExcercise.class);

    public static void main(String[] args) {
        IterableExcercise exercise = new IterableExcercise();
        exercise.iteratorInAction();
    }

    public void iteratorInAction() {
        TelevisionShowCollection showCollection = new TelevisionShowCollectionImpl();
        populateTelevisionShowCollection(showCollection);
        TelevisionShowIterator iterator = showCollection.iterator();
        TelevisionShowIterator channelIterator = showCollection.channelIterator(Channel.VTV3);

        LOGGER.info("Forward order");
        while (iterator.hasNext()) {
            LOGGER.info("{}", iterator.next());
        }
        LOGGER.info("**************************************************");
        LOGGER.info("Backward order");
        while (iterator.hasPrevious()) {
            LOGGER.info("{}", iterator.previous());
        }
        LOGGER.info("**************************************************");
        LOGGER.info("Filter by channel order");
        while (channelIterator.hasNext()) {
            LOGGER.info("{}", channelIterator.next());
        }
    }

    private void populateTelevisionShowCollection(TelevisionShowCollection showCollection) {
        showCollection.addShow(new TelevisionShow(95.0, Channel.VTV1, "Chuyen dong 24h"));
        showCollection.addShow(new TelevisionShow(95.0, Channel.VTV1, "Phim truyen"));
        showCollection.addShow(new TelevisionShow(95.0, Channel.VTV1, "Chao buoi sang"));
        showCollection.addShow(new TelevisionShow(97.0, Channel.VTV2, "Hanh trinh kham pha"));
        showCollection.addShow(new TelevisionShow(97.0, Channel.VTV2, "Ban cua nha nong"));
        showCollection.addShow(new TelevisionShow(97.0, Channel.VTV2, "Kham pha the gioi"));
        showCollection.addShow(new TelevisionShow(99.0, Channel.VTV3, "Chao buoi sang"));
        showCollection.addShow(new TelevisionShow(99.0, Channel.VTV3, "Phim truyen"));
        showCollection.addShow(new TelevisionShow(99.0, Channel.VTV3, "Duong len dinh =))"));
        showCollection.addShow(new TelevisionShow(101.0, Channel.HTV1, "Ban tin thoi su tong hop"));
        showCollection.addShow(new TelevisionShow(101.0, Channel.HTV1, "Khoa hoc cong nghe"));
        showCollection.addShow(new TelevisionShow(101.0, Channel.HTV1, "Chuong trinh thieu nhi"));
        showCollection.addShow(new TelevisionShow(103.0, Channel.HTV2, "Phim truyen trung quoc"));
        showCollection.addShow(new TelevisionShow(103.0, Channel.HTV2, "Phim truyen han quoc"));
        showCollection.addShow(new TelevisionShow(103.0, Channel.HTV2, "Phim truyen viet nam"));
        showCollection.addShow(new TelevisionShow(103.0, Channel.HTV2, "Phim truyen thai lan"));
        showCollection.addShow(new TelevisionShow(105.0, Channel.HTV3, "Nhung bai hoc thu vi"));
        showCollection.addShow(new TelevisionShow(105.0, Channel.HTV3, "7 vien ngon rong"));
        showCollection.addShow(new TelevisionShow(105.0, Channel.HTV3, "Doraemon"));
    }
}
