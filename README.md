App that loads a award nomination list and uses window functions to analyse data in order to discover who was the producer with two award with the smaller and greater interval between winnings.

The system uses H2 embedded database so no installation is required.

Records are imported to the database on system startup and are imported from the file movielist.csv contained in the src/main/resources folder.

The endpoint to get the min and max interval of winning streaks is GET /nomination-analysis/min-max-winning-streak