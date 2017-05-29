import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Du {

    private final boolean format;
    private final boolean sum;
    private final boolean numSyst;

    public Du(boolean format, boolean sum, boolean numSyst) {
        this.format = format;
        this.sum = sum;
        this.numSyst = numSyst;
    }

    private long fileSize(File file) {
        if (!file.isDirectory()) return file.length();
        else {
            File[] list = file.listFiles();
            long s = 0;
            for (int i = 0; i <= list.length - 1; i++) {
                if (list[i].isDirectory()) s += fileSize(list[i]);
                else s += list[i].length();
            }
            return s;
        }
    }

    public List answer(String[] fileN) {
        String[] list = {"B", "KB", "MB", "GB"};
        List ansList = new ArrayList();
        long s = 0;
        long size;
        int n = 1024;
        int form = 1;
        if (numSyst) n = 1000;
        for (int i = 0; i < fileN.length; i++) {
            form = 1;
            File file = new File(fileN[i]);
            if (!file.exists()) {
                ansList.clear();
                ansList.add("1 - ошибка");
                return ansList;
            }
            if (sum) s += fileSize(file);
            else {
                size = fileSize(file);
                if (format) {
                    form = 0;
                    while (size / n > 0) {
                        size /= n;
                        form++;
                    }
                    ansList.add("Размер " + fileN[i] + " равен " + size + " " + list[form]);
                } else {
                    size /= n;
                    ansList.add("Размер " + fileN[i] + " равен " + size);
                }
            }
        }
        if (sum) {
            if (format) {
                form = 0;
                while (s / n > 0) {
                    s /= n;
                    form++;
                }
                ansList.add("Суммарный размер файлов равен " + s + " " + list[form]);
            } else {
                s /= n;
                ansList.add("Суммарный размер файлов равен " + s);
            }
        }
        return ansList;
    }

    public void outWriter(List ansList) {
        for (int i = 0; i < ansList.size(); i++) System.out.println(ansList.get(i));
    }
}


