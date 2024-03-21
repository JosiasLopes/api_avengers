create table avenger (
    id bigserial not null,
    name varchar(36),
    primary key (id)
);

alter table avenger add constraint UK_5r88eemotwgru6k0ilqb2ledh unique (name);