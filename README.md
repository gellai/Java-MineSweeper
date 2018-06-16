# Minesweeper Game

![Minesweeper Game Java](https://gellai.com/wp-content/uploads/2018/02/MineSweeper.gif)

This project is about to replicate the Minesweeper game. The application is still under construction, however it is fully functional and playable.

At the moment the game has only a set grid, size and mine numbers.

* Columns: 15
* Rows: 30
* Number of mines: 30

**Java is required** for the application to run. The rest will be taken care of by Gradle. Tested on Java 1.7 and higher.

## Compile & Run (Linux)
This method requires **Git** to be installed. There is a good write up [here](https://git-scm.com/download/linux) about how to install it on Linux and Unix systems. Alternatively download the repository and uncompress it.

#### Get The Repository
After Git is up and running, use the following command to get the repository.

```
$ git clone git://github.com/gellai/java-minesweeper.git
```

#### Compile
```
$ cd java-minesweeper
$ chmod 755 gradlew
$ ./gradlew wrapper clean build
```

#### Run
```
$ ./gradlew run
```

>I've noticed that the application sometimes is not launching properly under Linux. For some reasons the run command needs to be executed several times to get the result (without rebuilding). I've been working on this issue.

## Compile & Run (Windows)
If you don't have Git installed then just [download the repository](https://github.com/gellai/java-minesweeper/archive/master.zip) and unzip it into a folder.

#### Compile
Open the command line and navigate to the folder which contains the unzipped files.

```
gradlew.bat wrapper clean build
```

#### Run
```
gradlew.bat run
```

## TO DO
* Add option for users to be able to change the difficulty level.
* Custom map
