tellraw @s [{"text":"THEALLSEEINGONE","color":"dark_aqua","bold":true,"italic":true,"obfuscated":true},{"text":" whispers to you: I'M GOING TO KILL YOU...","color":"gray","bold":false,"obfuscated":false}]
scoreboard players set @s sacri.eastereggs.howdoiproveit 1
playsound sacrilege:howdoiproveit player @s ~ ~ ~ 10
summon lightning_bolt ~ ~ ~
advancement grant @s only sacrilege:altars/offering
advancement grant @s only sacrilege:altars/reject