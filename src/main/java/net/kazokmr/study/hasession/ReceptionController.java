package net.kazokmr.study.hasession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
public class ReceptionController {

    private final Reception reception;

    @Autowired
    public ReceptionController(Reception reception) {
        this.reception = reception;
    }

    @GetMapping("/hello")
    public String hello() throws UnknownHostException {
        if (reception.getReceptionAt() == null) {
            reception.setHost(InetAddress.getLocalHost().getHostName());
            reception.setReceptionAt(LocalDateTime.now());
            reception.setMessage("セッション開始");
        } else {
            reception.setMessage("セッション中");
        }
        return String.format("%s,  ", reception.getMessage()) +
                String.format("Host: %s,  ", reception.getHost()) +
                String.format("受付日時: %s", reception.getReceptionAt());
    }

    @GetMapping("/bye")
    public String goodbye(HttpSession session) {
        session.invalidate();
        return "セッション切断";
    }
}
