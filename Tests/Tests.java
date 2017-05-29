import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    @Test
    public void test1() {
        String[] args = {"files/2.txt"};
        List list1 = new ArrayList();
        list1.add("Размер files/2.txt равен 19");
        DuLauncher.main(args);
        assertEquals(DuLauncher.list, list1);
    }

    @Test
    public void test2() {
        String[] args = {"-c", "files/1", "files/2.txt", "files/3.txt"};
        List list1 = new ArrayList();
        list1.add("Суммарный размер файлов равен 147");
        DuLauncher.main(args);
        assertEquals(DuLauncher.list, list1);
    }

    @Test
    public void test3() {
        String[] args = {"-c", "-h", "files/1", "files/2.txt", "files/3.txt"};
        List list1 = new ArrayList();
        list1.add("Суммарный размер файлов равен 147 KB");
        DuLauncher.main(args);
        assertEquals(DuLauncher.list, list1);
    }

    @Test
    public void test4() {
        String[] args = {"-h", "files/2.txt", "files/3.txt", "files/4.pdf"};
        List list1 = new ArrayList();
        list1.add("Размер files/2.txt равен 19 KB");
        list1.add("Размер files/3.txt равен 11 KB");
        list1.add("Размер files/4.pdf равен 53 MB");
        DuLauncher.main(args);
        assertEquals(DuLauncher.list, list1);
    }

    @Test
    public void test5() {
        String[] args = {"-h", "-si", "files/4.pdf"};
        List list1 = new ArrayList();
        list1.add("Размер files/4.pdf равен 56 MB");
        DuLauncher.main(args);
        assertEquals(DuLauncher.list, list1);
    }

}
