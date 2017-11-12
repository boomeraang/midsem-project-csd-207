## 12.11.17
### commit ec8d076e2eadf8b9a19d382d69e0d664f3bab4df

#### TouristDrone
* added SuggestPlaces()

#### Places
* added field distance

#### FileIO
* overloaded searchplacesonfile() for suggesting places

#### Cops
* modified wherami() call

#### Tourists
* modified wherami() call


## 9.11.17

### commit 365a86ef5eacf5c75c71f5dfb13938c41ccdcb99

#### Cop Drone
* added ReportCrime()
* randomised ReportCrime(boolean automate)
* added ShowReports() connects to SearchFile()

#### FileIO
* added SearchFile()

### commit a504e9b780a1b0f42ec07d6bb9baa0a2d751e39b

#### Drone
* moved functions AddUser(), WhereAmI(), MoveDrone() up to Drone

#### FileIO
* added WriteText()

* other minor changes

### commit 697c5a71007ce4c7c7fbd5c7ae24a4cd63627b95

#### Tourist Drone
* WhereAmI() added
* TouristMenu() acts like an interface to class TouristDrone

#### Tourists
* deleting account now logs the user out automatically
* a new empty constructor
* tourists are added as tourists now

## 8.11.17

### commit d1e63f3d046c2c6d9637f25d198c20a21d499db6
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
