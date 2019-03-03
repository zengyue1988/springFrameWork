create table moonschema.M_USER_ATTEMPTS
(
	username  VARCHAR(64) not null,
    attempts int(4),
    last_modified DATE
);
alter table moonschema.M_USER_ATTEMPTS
add constraint PK_M_USER_ATTEMPTS primary key (username);