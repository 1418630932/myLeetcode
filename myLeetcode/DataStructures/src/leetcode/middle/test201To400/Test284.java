package leetcode.middle.test201To400;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-26
 * @time 11:30
 **/
public class Test284 {
    class PeekingIterator implements Iterator<Integer> {
        private Queue<Integer> queue = new LinkedList();
        public PeekingIterator(Iterator<Integer> iterator) {
            queue = new LinkedList<>();
            while (iterator.hasNext()) {
                queue.add(iterator.next());
            }
        }

        public Integer peek() {
            return queue.peek();
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
