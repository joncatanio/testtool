# testtool
Test tool for CPE 307

#### Login into the TestTool App
There are two workflows for the application. A student workflow and a teacher workflow. Students are only allowed to take tests and teachers are allowed to design and create tests and questions.
##### Teacher Login
Username: teacher Password: password
##### Student Login
Username: student Password: password

#### Running TestTool
Locate the shell script in the root directory called "Run-TestTool.sh" and simply
execute the shell file with the command "./Run-TestTool.sh". Make sure you are 
in the same directory as the file.

#### What to do when committing
We add all of our files to Intellij's src directory. When you are 
committing new files we must track the src files by "git add"ing them. 
One issue that must be dealt with is that when one compiles or runs our 
project Intellij duplicates the executable version of your newly added 
file(s) and puts it into the directory titled "out" ... you must also track
these files. 

Moral of the story, when you are going to add files to the git repo make 
sure you compile the project then go ahead and add all the newly created
files. 

#### Help SceneBuilder won't load externally from right clicking on my .fxml file!
This is fixable! If you are on a MacBook locate the SceneBuilder.app 
(probably in Applications/SceneBuilder). Right click on SceneBuilder.app
and open package contents. Change directories into the directory titled
"MacOS" there you will see a SceneBuilder executable file. Copy this file
in the same directory and name the copy "scenebuilder-launcher.sh" now
you will be able to open SceneBuilder externally from Intellij.
