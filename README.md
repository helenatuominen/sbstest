# SBS Coding Questions, Java
Hi there! For development I've used the following tools, please make sure you have
an appropriate build environment setup. The questions are present in this repo
 [sbs_tech_assessment_code_only.txt](src/main/java/net/burnandbury/sbstest/doc-files/sbs_tech_assessment_code_only.txt)


- JDK 16.0.1
- Maven 3.8.1
- Eclipse 2021-06 (4.20.0). Project files can be found in the repository for import to a workspace.

With the above installed correctly, building and executing the unit tests can be achieved via executing:

```
  mvn clean test
```

The code is executed by unit tests under corresponding packages in the /src/test/java directory,
and all code is located under my package namespace of net.burnandbury.sbstest.*

## Challenge 1.1
Code is a set of classes, records, interfaces and enums in an appropriate OOP breakdown of 
a deck of cards. Abstractions were made to allow future flexibility of playing Uno or other card games.

Code:
- [net.burnandbury.sbstest.cards.*](src/main/java/net/burnandbury/sbstest/cards)

Unit Tests:
- [net.burnandbury.sbstest.cards.ChallengeOneStandardDeckTest](src/test/java/net/burnandbury/sbstest/cards/ChallengeOneStandardDeckTest.java)

## Challenge 1.2
Not necessarily the most optimal, but I enjoyed writing it. Originally there were plans to embed some sort
of emulator and execute the code in BASIC. But that's too many characters, another time.

Code for functions:
- [net.burnandbury.sbstest.cards.MumMumMumMah](src/main/java/net/burnandbury/sbstest/cards/MumMumMumMah.java)

Unit Tests:
- [net.burnandbury.sbstest.cards.ChallengeTwoStraightAndFlushTest](src/test/java/net/burnandbury/sbstest/cards/ChallengeTwoStraightAndFlushTest.java)

## Challenge 1.3
Straightforward solve for this problem.

Code for function:

- [net.burnandbury.sbstest.water.WaterVolume](src/main/java/net/burnandbury/sbstest/water/WaterVolume.java)


Unit Tests:

- [net.burnandbury.sbstest.water.ChallengeThreeWaterVolumeTest](src/test/java/net/burnandbury/sbstest/water/ChallengeThreeWaterVolumeTest.java)


## Challenge 1.4
I think the algorithm can be improved with recursion at cost of cycles, O(n^2) maybe? I kept it simple.
Code for function:

- [net.burnandbury.sbstest.stock.StockHistory](src/main/java/net/burnandbury/sbstest/stock/StockHistory.java)


Unit Tests:

- [net.burnandbury.sbstest.stock.ChallengeFourStockHistoryTest](src/test/java/net/burnandbury/sbstest/stock/ChallengeFourStockHistoryTest.java)

