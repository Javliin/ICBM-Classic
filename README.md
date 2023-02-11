![Java CI](https://github.com/BuiltBrokenModding/ICBM-Classic/workflows/Java%20CI/badge.svg) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=BuiltBrokenModding_ICBM-Classic&metric=alert_status)](https://sonarcloud.io/dashboard?id=BuiltBrokenModding_ICBM-Classic) [![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=BuiltBrokenModding_ICBM-Classic&metric=ncloc)](https://sonarcloud.io/dashboard?id=BuiltBrokenModding_ICBM-Classic) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=BuiltBrokenModding_ICBM-Classic&metric=coverage)](https://sonarcloud.io/dashboard?id=BuiltBrokenModding_ICBM-Classic) 

# Info
ICBM-Classic is an addon for the game Minecraft via MinecraftForge. It provides a series of small explosive missiles and launchers.

This fork adds CC: Tweaked integration, allowing you to control missile launchers with computers. 

# Description
ICBM is a Minecraft Mod that introduces intercontinental ballistic missiles to Minecraft. But the fun doesn't end there! This mod also features many different explosives, missiles and machines classified in four different tiers. If strategic warfare, carefully coordinated airstrikes, messing with matter and general destruction are up your alley, then this mod is for you!

# Install
1.7.10 version requires VoltzEngine to function
1.12 has no dependencies

# Download 
Check the releases page

# Usage
Launch control panels are treated as a normal peripheral. To use, place a computer down adjacent to a launch control panel.
```
lua> mc = peripheral.wrap("right") -- Wraps a control panel on the right side
```
```
lua> mc = peripheral.find("missilecontrol") -- Looks for an attached control panel
```
Higher tier control panels have more available methods, and inherit all methods from lower tiers.
## T1
```
launchMissile() -- Attempts to launch a missile.
getTarget() -- Retrieves the X,Y,Z of the target position. 
               Returns: int, int, int
setTarget(int x, int z) -- Sets the X,Z of the target position.
```
## T2
```
getLockHeight() -- Retrieves the lock height.
                   Returns: int
setLockHeight(int y) -- Sets the lock height.
setTarget(int x, int y, int z) -- Overwrites T1 method. Sets the X,Y,Z of the target position.
```
## T3
```
getFrequency() -- Retrieves the frequency.
                  Returns: int
setFrequency(int frequency) -- Sets the frequency.
```
Out of bounds values are accepted, but will be rounded to the nearest inbound value.
# Credits
Credits are a work in progress and will need to be recreated
* bl4ckscor3 - code
* Calcalvia - orginal author
* DarkGuardsman/DarkCow - current author
* Dmod - buildscripts
* GHXX - code
* Graugger - assets
* M1W3st - assets
* Tgame14 - code

## Freesound.org 
* primeval_polypod      https://freesound.org/people/primeval_polypod/sounds/158894/


# Development

## Tools

* Sonar https://sonarcloud.io/dashboard?id=BuiltBrokenModding_ICBM-Classic
