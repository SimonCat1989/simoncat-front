# ref: http://blog.csdn.net/goldenhawking/article/details/7952303

# 安装PostgreSQL
sudo apt-get update  
sudo apt-get dist-upgrade  
sudo apt-get install postgresql  
sudo apt-get install postgresql-9.1-postgis postgresql-contrib-9.1 postgresql-server-dev-9.1  
sudo apt-get install libpq-dev

# 更改Linux用户和PostgreSQL 的用户密码，创建用于数据访问的用户
echo "Please input password for 'postgres' in twice."
sudo passwd postgres 

sudo su postgres

echo "Please input: ALTER USER postgres WITH PASSWORD 'your password';"
psql -dpostgres


# 为了安全，创建一个用户，用于数据访问。为了和后面渲染契合，用户名 www-data，分别在console以及psql下执行
sudo passwd www-data
echo "Please input password for 'www-data' in twice."

echo "Please input: CREATE ROLE "www-data" LOGIN PASSWORD 'your password' SUPERUSER INHERIT CREATEDB NOCREATEROLE REPLICATION;"
psql -dpostgres

# 建立PostGIS数据库
sudo mkdir pgtbs_osmgis  
sudo chown postgres ./pgtbs_osmgis 

echo "Please input: CREATE TABLESPACE pgtbs_osmgis OWNER "www-data" LOCATION '.../pgtbs_osmgis';"
psql -dpostgres


echo "Please input: CREATE DATABASE osmgis WITH OWNER = "www-data" ENCODING = 'UTF8' TABLESPACE = pgtbs_osmgis LC_COLLATE = 'C' LC_CTYPE = 'C' CONNECTION LIMIT = -1;"
psql -dpostgres

echo "Please input: GRANT ALL ON DATABASE osmgis TO public;"
psql -dpostgres

echo "Please input: GRANT ALL ON DATABASE osmgis TO "www-data";"
psql -dpostgres

sudo su postgres -c "psql -dosmgis </usr/share/postgresql/9.1/contrib/postgis-1.5/postgis.sql"  
sudo su postgres -c "psql -dosmgis </usr/share/postgresql/9.1/contrib/postgis-1.5/spatial_ref_sys.sql"  
sudo su postgres -c "psql -dosmgis </usr/share/postgresql/9.1/contrib/postgis_comments.sql"  
sudo su postgres  

echo "Please input: create extension hstore"
psql -dosmgis

echo "shared_buffers = 256MB"  
echo "checkpoint_segments = 20"  
echo "maintenance_work_mem = 256MB"  
echo "autovacuum = off"
sudo gedit /etc/postgresql/9.1/main/postgresql.conf

echo "#128MB shared_buffer对应256MB shmmax"    
echo "kernel.shmmax=268435456"    
echo "#256MB shared_buffer对应512MB"    
echo "shmmax kernel.shmmax=536870912"  
sudo gedit /etc/sysctl.conf