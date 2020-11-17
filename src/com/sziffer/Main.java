package com.sziffer;


import com.sziffer.model.Categories;
import com.sziffer.model.blog.BlogEntry;
import com.sziffer.model.blog.BlogEntryComment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        URI myUri = URI.create("src/com/sziffer/hibernate.cfg.xml");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("/com/sziffer/hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // Adding favourite chocolate
        Categories categories1 = new Categories();
        categories1.setDescription("A Mozartkugel, is a small, round sugar confection made of pistachio marzipan and nougat that is covered with dark chocolate.");
        categories1.setName("Mozartkugel");
        Categories categories2 = new Categories();
        categories2.setName("Pocket Caffee");
        categories2.setDescription("Pocket Coffee is a brand of the Ferrero company for a chocolate confectionery, sold internationally.");
        session.save(categories1);
        session.save(categories2);

        // Testing Blog DB
        BlogEntry blogEntry = new BlogEntry();
        blogEntry.setLongName("Long blog entry name");
        blogEntry.setName("Medium");
        blogEntry.setBlogEntryDate(new Date());

        BlogEntryComment blogEntryComment = new BlogEntryComment();
        blogEntryComment.setCommentText("Pocket Coffee is a brand of the Ferrero company for a chocolate confectionery, sold internationally.");
        blogEntryComment.setCommentDate(new Date());
        blogEntryComment.setBlogEntry(blogEntry);


        BlogEntryComment blogEntryComment2 = new BlogEntryComment();
        blogEntryComment2.setCommentText("Pocket Coffee is a brand of the Ferrero company for a chocolate confectionery, sold internationally.");
        blogEntryComment2.setCommentDate(new Date());
        blogEntryComment2.setBlogEntry(blogEntry);


        BlogEntryComment blogEntryComment3 = new BlogEntryComment();
        blogEntryComment3.setCommentText("Pocket Coffee is a brand of the Ferrero company for a chocolate confectionery, sold internationally.");
        blogEntryComment3.setCommentDate(new Date());
        blogEntryComment3.setBlogEntry(blogEntry);


        Set<BlogEntryComment> comments = new HashSet<>();
        comments.add(blogEntryComment);
        comments.add(blogEntryComment2);
        comments.add(blogEntryComment3);

        blogEntry.setComments(comments);
        session.save(blogEntry);
        session.save(blogEntryComment);
        session.save(blogEntryComment2);
        session.save(blogEntryComment3);

        transaction.commit();
        factory.close();
        session.close();
    }
}
