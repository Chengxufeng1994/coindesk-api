create table correspond_currency (id bigint generated by default as identity, chinese_code varchar(255), code varchar(255), rate varchar(255), primary key (id))
create table updated_time_record (id bigint generated by default as identity, type varchar(255), updated_time bigint, primary key (id))