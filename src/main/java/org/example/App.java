package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHiber;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Наша первое CRUD приложение с работой Базы данных
 * CRUD
 * Create - создать пользовтаеля
 * Read - считать пользователя
 * Update - обновление
 * Delete - удаление
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
