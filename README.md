# CorpusWorkerRPG
Text-based RPG based on Warframe. You play as a Corpus worker, trying to work your way out of debt. Managing efficiency versus time worked, and trying to get sleep and meals in are important features. The option to replace body parts to raise your wages is available, and repo squads will come after you if your debt gets too high.

Update 4 notes:
- updated work to accurately reflect working multiple days with lowering efficiency
- updated new day counter to prevent efficiency from reaching negative values
- removed unnecessary variables
- fixed working not giving any money after day 1

Update 3 notes:
- added checks for invalid entries
- added default case for repo team
- removed lines used for testing
- removed unnecessary variable
- fixed spelling errors
- fixed day counter not updating correctly
- updated wages
- updated repo text to be easier to read and more accurate to gameplay
- updated eating text
- updated game-over requirements so game ends when intMods == 4 and intDebt >= 300000, rather than just intMods == 4
