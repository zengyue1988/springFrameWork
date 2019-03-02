create table moonschema.PERSISTENT_LOGINS
(
	username  VARCHAR(64) not null,
    series    VARCHAR(64) not null,
    token     VARCHAR(64) not null,
    last_used DATE not null
);
alter table moonschema.PERSISTENT_LOGINS
add constraint PK_PERSISTENT_LOGINS primary key (series);