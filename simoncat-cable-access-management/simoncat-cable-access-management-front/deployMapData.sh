sudo apt-get install subversion git-core tar unzip wget bzip2   
sudo apt-get install build-essential autoconf libtool libxml2-dev libgeos-dev libbz2-dev   
sudo apt-get install proj libprotobuf-c0-dev protobuf-c-compiler   
sudo apt-get install libfreetype6-dev libpng12-dev libtiff4-dev libicu-dev libboost-all-dev   
sudo apt-get install libgdal-dev libcairo-dev libcairomm-1.0-dev apache2 apache2-dev libagg-dev

mkdir ~/src  
mkdir ~/bin  
cd ~/bin  
svn co http://svn.openstreetmap.org/applications/utils/export/osm2pgsql/

cd osm2pgsql  
./autogen.sh  
./configure  
make  
sudo make install 

./osm2pgsql -dosmgis -s -S"./default.style" -C384 -Uwww-data -W -Hlocalhost -v ~/Downloads/china-latest.osm.pbf