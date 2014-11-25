#Lib Changer
 note: This app is specially created to use with L Camera (https://github.com/PkmX/lcamera)

![picture](https://cloud.githubusercontent.com/assets/9750068/5184663/15a42aea-74db-11e4-8668-445c779edca8.jpg)

#ONLY WORKS WITH ROOT and BUSYBOX

You can download the latest release [Here](https://github.com/modbrin/libchanger/releases)
#INSTALLATION:
1) Copy LC-Cache folder to your /sdcard


2) Run LIBCHANGER_v0.3.apk

#How this works:
#1'
Then you press "Install 60 fps mod" app asks for SU access, then it copies the original lib 
from /system/lib/limmcamera_imx179.so to /sdcard/LC-Cache/backup, 
so if something goes wrong you will be able to restore using terminal.
At the end it installs modified lib from /sdcard/LC-Cache/mod.so to /system/...
#2'
Then you press "Restore to normal" app uses SU access, then it installs original lib from /sdcard/LC-Cache/orig.so to /system/...
#3'
You can use any mod lib instead of libmmcamera_imx179_60hz.so, just copy your mod into LC-Cache folder. It must have name mod.so
