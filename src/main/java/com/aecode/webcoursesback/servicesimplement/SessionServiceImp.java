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
        String paragraphStyle = "font-family: 'Plus Jakarta Sans', sans-serif; font-size: 14px; color: #000; line-height: 24px; text-align: justify; font-style: normal; font-weight: 300; margin-bottom: 15px;";
        String containerStyle = "text-align: justify;"; // Estilo adicional para justificación

        // Construcción del contenido de párrafos con el estilo en cada <p>
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div style=\"").append(containerStyle).append("\">"); // Agrega un contenedor div
        String[] paragraphs = resourceText.split("\n\n");

        for (String paragraph : paragraphs) {
            htmlBuilder.append("<p style=\"").append(paragraphStyle).append("\">").append(paragraph).append("</p>");
        }

        htmlBuilder.append("</div>"); // Cierra el contenedor div
        return htmlBuilder.toString();
    }

}
