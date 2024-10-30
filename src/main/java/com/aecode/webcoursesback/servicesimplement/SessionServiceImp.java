package com.aecode.webcoursesback.servicesimplement;

import com.aecode.webcoursesback.entities.Session;
import com.aecode.webcoursesback.repositories.ISessionRepo;
import com.aecode.webcoursesback.services.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImp implements ISessionService {
    @Autowired
    private ISessionRepo cR;

    @Override
    public void insert(Session classes) {
        cR.save(classes);
    }

    @Override
    public List<Session> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int classId) {
        cR.deleteById(classId);
    }

    @Override
    public Session listId(int classId) {
        return cR.findById(classId).orElse(new Session());
    }

    @Override
    public List<Session> findByTitle(String title) {
        return cR.searchByTitle(title);
    }

    @Override
    public String wrapInHtml(String resourceText) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='es'>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset='UTF-8'>");
        htmlBuilder.append("<title>Descripción de la Sesión</title>");
        htmlBuilder.append("<link href='https://fonts.googleapis.com/css?family=Plus+Jakarta+Sans&display=swap' rel='stylesheet'>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { font-family: 'Plus Jakarta Sans', sans-serif; font-size: 14px; color: #000; line-height: 24px; text-align: justify; font-style: normal; font-weight: 300; }");
        htmlBuilder.append("p { margin-bottom: 15px; }");
        htmlBuilder.append("</style>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");

        // Agrega cada párrafo con un tag <p>
        String[] paragraphs = resourceText.split("\n\n");
        for (String paragraph : paragraphs) {
            htmlBuilder.append("<p>").append(paragraph).append("</p>");
        }

        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
