package lv.akurss;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args) throws Exception{

        String url = "http://bash.im/rss/";
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
        log.info("RSS feed from {}", feed.getTitle());
        feed.getEntries().stream()
            .map(it -> it.getDescription())
            .forEach(it -> log.info(format(it.getValue())));

        System.out.println("!");
    }

    protected static String format(String str){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n=======================\n");
        sb.append(StringEscapeUtils.unescapeHtml4(str).replace("<br>", "\n"));
        sb.append("\n====================\n");
        return sb.toString();

    }

}
