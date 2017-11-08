## 8.11.17

### commit
#### Admin
* removed DeleteUser(). now in class Users

#### User
* added 2 explicit constructors

#### FileIO
* added ChangePasswordfromFile()
* modified DeleteUserfromFile()

## 5.11.17

### commit 5f950d60c30d4109df70e37afeb8ff99a5ce575b
#### Main menu
* finished main menu


#### Cop admin
* created class CopAdmin extends Admin
* menu to interact with cops.txt
#### Cops
* added class Cops extends user
* basic menu for interacting with CopDrone


### commit c8fa572b9cd996fb6f7dbb5f5ef178347be1c275

#### User
* added coordinate fields for users
* setters and getters for coordinates
#### Tourists
* created a new tourists class with a menu calling TouristDrone functions

### commit 63cdea0de1514141095180c5cfe442277917eab9

#### Tourist drone
* replaced an if else if block with just a single case using string concatenation
#### Admin stuff
* deprecated admin login
#### FileIO
* added a generic login function that takes id, password, file to search. replaces AdminLogin()



## 4.11.17
#### Admin stuff
* made class Admin abstract
* new classes TouristAdmin and CopAdmin
* added AddAdmin and DeleteUser functions
* added tourist admin menu
#### Main menu stuff
* defined a few more options
