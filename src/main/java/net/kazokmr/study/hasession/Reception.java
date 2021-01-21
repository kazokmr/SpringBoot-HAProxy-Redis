package net.kazokmr.study.hasession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@SessionScope
public class Reception implements Serializable {

    private static final long serialVersionUID = -3101986789734320497L;

    private String host;
    private LocalDateTime receptionAt;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getReceptionAt() {
        return receptionAt == null ? null : DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(receptionAt);
    }

    public void setReceptionAt(LocalDateTime receptionAt) {
        this.receptionAt = receptionAt;
    }
}
