execute if entity @s[tag=howdoiproveit] as @p at @s run function sacrilege:altar/offerings/eastereggs/howdoiproveit/1
execute if entity @s[tag=howdoiproveit] run tag @s remove howdoiproveit
execute if entity @s[tag=sweeping] run function sacrilege:altar/offerings/eastereggs/sweeping
execute if entity @s[tag=sweeping] run tag @s remove sweeping
execute if entity @s[tag=0zymandiu5] run function sacrilege:altar/offerings/eastereggs/devs/0zymandiu5
execute if entity @s[tag=0zymandiu5] run tag @s remove 0zymandiu5
execute if entity @s[tag=ExistingEevee] run function sacrilege:altar/offerings/eastereggs/devs/existingeevee
execute if entity @s[tag=ExistingEevee] run tag @s remove ExistingEevee
execute if entity @s[tag=Sweebow] run function sacrilege:altar/offerings/eastereggs/devs/sweebow
execute if entity @s[tag=Sweebow] run tag @s remove Sweebow
execute if entity @s[tag=Termineitron] run function sacrilege:altar/offerings/eastereggs/devs/termineitron
execute if entity @s[tag=Termineitron] run tag @s remove Termineitron
execute if entity @s[tag=Modrome] run function sacrilege:altar/offerings/eastereggs/devs/modrome
execute if entity @s[tag=Modrome] run tag @s remove Modrome
execute if entity @s[tag=fartar] as @p at @s run function sacrilege:altar/offerings/eastereggs/altar
execute if entity @s[tag=fartar] run tag @s remove fartar
execute if entity @s[tag=cult] at @s run function sacrilege:altar/offerings/cults/add
execute if entity @s[tag=cult] run tag @s remove cult

execute if entity @s[tag=sculk] if entity @s[tag=repulsive] run function sacrilege:altar/offerings/sculk/repulsive
execute if entity @s[tag=sculk] if entity @s[tag=undesirable] run function sacrilege:altar/offerings/sculk/undesirable
execute if entity @s[tag=sculk] if entity @s[tag=mediocre] run function sacrilege:altar/offerings/sculk/mediocre
execute if entity @s[tag=sculk] if entity @s[tag=prodigious] run function sacrilege:altar/offerings/sculk/prodigious
execute if entity @s[tag=sculk] if entity @s[tag=consummate] run function sacrilege:altar/offerings/sculk/consummate

execute if entity @s[tag=repulsive] run tag @s remove repulsive
execute if entity @s[tag=undesirable] run tag @s remove undesirable
execute if entity @s[tag=mediocre] run tag @s remove mediocre
execute if entity @s[tag=prodigious] run tag @s remove prodigious
execute if entity @s[tag=consummate] run tag @s remove consummate

scoreboard players reset @s sacri.altarVerdictTimer
tag @s remove offering