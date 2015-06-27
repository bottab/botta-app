          create table botta.T_City (
        id number(10,0) not null,
        optlock date,
        city varchar2(255),
        zip varchar2(255),
        primary key (id)
    );

    create table botta.T_Code (
        id number(10,0) not null,
        optlock date,
        type varchar2(255),
        value varchar2(255),
        primary key (id)
    );

    create table botta.T_Contact (
        id number(10,0) not null,
        optlock date,
        co varchar2(255),
        email varchar2(255),
        mobile varchar2(255),
        phone varchar2(255),
        street varchar2(255),
        primary key (id)
    );

    create table botta.T_Country (
        id number(10,0) not null,
        optlock date,
        country varchar2(255),
        primary key (id)
    );

    create table botta.T_Customer (
        id number(10,0) not null,
        optlock date,
        birthdate date,
        firstname varchar2(255),
        gender varchar2(255),
        name varchar2(255),
        nationality varchar2(255),
        titel varchar2(255),
        type varchar2(255),
        primary key (id)
    );

    create table botta.T_Customer_Info (
        id number(10,0) not null,
        optlock date,
        infoPrivate varchar2(255),
        infoPublic varchar2(255),
        sponsor varchar2(255),
        customer_id number(10,0),
        primary key (id)
    );

    create table botta.T_R_CITY_REGION (
        region_id number(10,0) not null,
        city_id number(10,0) not null,
        primary key (city_id)
    );

    create table botta.T_R_CONTACT_CITY (
        city_id number(10,0) not null,
        contact_id number(10,0) not null,
        primary key (contact_id)
    );

    create table botta.T_R_CONTACT_CODE (
        code_id number(10,0) not null,
        contact_id number(10,0) not null,
        primary key (contact_id)
    );

    create table botta.T_R_CONTACT_COUNTRY (
        country_id number(10,0) not null,
        contact_id number(10,0) not null,
        primary key (contact_id)
    );

    create table botta.T_R_CONTACT_CUSTOMER (
        customer_id number(10,0) not null,
        contact_id number(10,0) not null,
        primary key (contact_id)
    );

    create table botta.T_R_CONTACT_REGION (
        region_id number(10,0) not null,
        contact_id number(10,0) not null,
        primary key (contact_id)
    );

    create table botta.T_R_CONTACT_STATE (
        state_id number(10,0) not null,
        contact_id number(10,0) not null,
        primary key (contact_id)
    );

    create table botta.T_R_CUSTOMER_CODE (
        code_id number(10,0) not null,
        customer_id number(10,0) not null,
        primary key (customer_id)
    );

    create table botta.T_R_CUSTOMER_CUSTOMER_INFO (
        customer_id number(10,0) not null,
        primary key (customer_id)
    );

    create table botta.T_R_CUSTOMER_INFO_CODE (
        code_id number(10,0) not null,
        customer_info_id number(10,0) not null,
        primary key (customer_info_id)
    );

    create table botta.T_R_CUSTOMER_USER (
        user_id number(10,0) not null,
        customer_id number(10,0) not null,
        primary key (customer_id)
    );

    create table botta.T_R_REGION_STATE (
        state_id number(10,0) not null,
        region_id number(10,0) not null,
        primary key (region_id)
    );

    create table botta.T_R_STATE_COUNTRY (
        country_id number(10,0) not null,
        state_id number(10,0) not null,
        primary key (state_id)
    );

    create table botta.T_R_USER_CODE (
        code_id number(10,0) not null,
        user_id number(10,0) not null,
        primary key (user_id)
    );

    create table botta.T_R_USER_ROLE (
        USER_ID number(10,0) not null,
        ROLE_ID number(10,0) not null
    );

    create table botta.T_Region (
        id number(10,0) not null,
        optlock date,
        region varchar2(255),
        primary key (id)
    );

    create table botta.T_Role (
        id number(10,0) not null,
        optlock date,
        role varchar2(255),
        primary key (id)
    );

    create table botta.T_State (
        id number(10,0) not null,
        optlock date,
        state varchar2(255),
        primary key (id)
    );

    create table botta.T_User (
        id number(10,0) not null,
        optlock date,
        password varchar2(255),
        username varchar2(255),
        primary key (id)
    );

    alter table botta.T_Customer_Info 
        add constraint FKFD132BC498988A93 
        foreign key (customer_id) 
        references botta.T_Customer;

    alter table botta.T_R_CITY_REGION 
        add constraint FK24054B3078728178 
        foreign key (region_id) 
        references botta.T_Region;

    alter table botta.T_R_CITY_REGION 
        add constraint FK24054B301C435198 
        foreign key (city_id) 
        references botta.T_City;

    alter table botta.T_R_CONTACT_CITY 
        add constraint FKFF8D462B3925901 
        foreign key (contact_id) 
        references botta.T_Contact;

    alter table botta.T_R_CONTACT_CITY 
        add constraint FKFF8D4621C435198 
        foreign key (city_id) 
        references botta.T_City;

    alter table botta.T_R_CONTACT_CODE 
        add constraint FKFF8E8E4B3925901 
        foreign key (contact_id) 
        references botta.T_Contact;

    alter table botta.T_R_CONTACT_CODE 
        add constraint FKFF8E8E447D4F084 
        foreign key (code_id) 
        references botta.T_Code;

    alter table botta.T_R_CONTACT_COUNTRY 
        add constraint FKB7DAA91FB3925901 
        foreign key (contact_id) 
        references botta.T_Contact;

    alter table botta.T_R_CONTACT_COUNTRY 
        add constraint FKB7DAA91FC832E57C 
        foreign key (country_id) 
        references botta.T_Country;

    alter table botta.T_R_CONTACT_CUSTOMER 
        add constraint FK7DC85F55B3925901 
        foreign key (contact_id) 
        references botta.T_Contact;

    alter table botta.T_R_CONTACT_CUSTOMER 
        add constraint FK7DC85F5598988A93 
        foreign key (customer_id) 
        references botta.T_Customer;

    alter table botta.T_R_CONTACT_REGION 
        add constraint FKE6F7C2BB3925901 
        foreign key (contact_id) 
        references botta.T_Contact;

    alter table botta.T_R_CONTACT_REGION 
        add constraint FKE6F7C2B78728178 
        foreign key (region_id) 
        references botta.T_Region;

    alter table botta.T_R_CONTACT_STATE 
        add constraint FKF007E85A1054781C 
        foreign key (state_id) 
        references botta.T_State;

    alter table botta.T_R_CONTACT_STATE 
        add constraint FKF007E85AB3925901 
        foreign key (contact_id) 
        references botta.T_Contact;

    alter table botta.T_R_CUSTOMER_CODE 
        add constraint FK228329698988A93 
        foreign key (customer_id) 
        references botta.T_Customer;

    alter table botta.T_R_CUSTOMER_CODE 
        add constraint FK228329647D4F084 
        foreign key (code_id) 
        references botta.T_Code;

    alter table botta.T_R_CUSTOMER_CUSTOMER_INFO 
        add constraint FK710781E698988A93 
        foreign key (customer_id) 
        references botta.T_Customer;

    alter table botta.T_R_CUSTOMER_INFO_CODE 
        add constraint FKFB0EB3D547D4F084 
        foreign key (code_id) 
        references botta.T_Code;

    alter table botta.T_R_CUSTOMER_INFO_CODE 
        add constraint FKFB0EB3D5DE2861B0 
        foreign key (customer_info_id) 
        references botta.T_Customer_Info;

    alter table botta.T_R_CUSTOMER_USER 
        add constraint FK2307074F36571D1 
        foreign key (user_id) 
        references botta.T_User;

    alter table botta.T_R_CUSTOMER_USER 
        add constraint FK230707498988A93 
        foreign key (customer_id) 
        references botta.T_Customer;

    alter table botta.T_R_REGION_STATE 
        add constraint FKABD87D7E1054781C 
        foreign key (state_id) 
        references botta.T_State;

    alter table botta.T_R_REGION_STATE 
        add constraint FKABD87D7E78728178 
        foreign key (region_id) 
        references botta.T_Region;

    alter table botta.T_R_STATE_COUNTRY 
        add constraint FK7E485E901054781C 
        foreign key (state_id) 
        references botta.T_State;

    alter table botta.T_R_STATE_COUNTRY 
        add constraint FK7E485E90C832E57C 
        foreign key (country_id) 
        references botta.T_Country;

    alter table botta.T_R_USER_CODE 
        add constraint FK327CDEC9F36571D1 
        foreign key (user_id) 
        references botta.T_User;

    alter table botta.T_R_USER_CODE 
        add constraint FK327CDEC947D4F084 
        foreign key (code_id) 
        references botta.T_Code;

    alter table botta.T_R_USER_ROLE 
        add constraint FK3283B1524E3AADF1 
        foreign key (ROLE_ID) 
        references botta.T_Role;

    alter table botta.T_R_USER_ROLE 
        add constraint FK3283B152F36571D1 
        foreign key (USER_ID) 
        references botta.T_User;

        CREATE Sequence botta.botta_sequence Start with 1;
	commit;