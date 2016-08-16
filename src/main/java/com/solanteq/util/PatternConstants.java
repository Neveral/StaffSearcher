package com.solanteq.util;


/*
    (                   # Начало группы
        (?=.*\d)		#   должен содержать хотя бы одну цифру
        (?=.*[a-z])	    #   должен содержать хотябы одну букву в нижнем регистре
        (?=.*[A-Z])	    #   должен содержать хотябы одну букву в верхнем регистре
        (?=.*[@#$%])	#   должен содержать один специальный символ из "@#$%"
        .		        #   любое совпадение с предыдущими условиями
        {7,}	        #   длина от 7 символов
        .*              #   любой символ сколько угодно раз // (!!!) не уверен в правильности этого решения
    )

*/

public class PatternConstants {
    // паттерн для ФИО работника (с ограничением 0-40 символов, которыми могут быть буквы и цифры, дефис, нижнее подчеркивание и точку, первый символ обязательно буква):
    public static final String NAME_PATTERN = "^[а-яА-ЯёЁa-zA-Z][а-яА-ЯёЁa-zA-Z0-9]{0,40}$";


    // Должность работника (с ограничением 0-40 символов, которыми могут быть буквы и цифры, дефис, нижнее подчеркивание и пробел, первый символ обязательно буква):
    public static final String POSITION_PATTERN = "^[а-яА-ЯёЁa-zA-Z][а-яА-ЯёЁa-zA-Z0-9-_ ]{0,40}$";


    public static final String BIRTHDAY_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
}