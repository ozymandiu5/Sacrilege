data modify entity @s item set from entity @p SelectedItem
execute if data entity @s {item:{tag:{display:{Name:'{"text":"How do I prove it"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add howdoiproveit
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"0zymandiu5"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add 0zymandiu5
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"ExistingEevee"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add ExistingEevee
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Sweebow"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Sweebow
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Lightigivhi"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Lightigivhi
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"21fishbowls"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add 21fishbowls
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"DanieloXXelo"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add DanieloXXelo
execute if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Modrome"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Modrome
execute if data entity @s {item:{tag:{display:{Name:'{"text":"sweeping"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add sweeping
execute if data entity @s {item:{id:"sacrilege:altar"}} run tag @e[tag=altar,limit=1,sort=nearest] add fartar
execute if data entity @s {item:{id:"sacrilege:blood_bottle"}} as @e[tag=altar,limit=1,sort=nearest] run function sacrilege:altar/offerings/cults/detect

execute as @e[tag=altar,limit=1,sort=nearest] if entity @s[tag=sculk] unless predicate sacrilege:offerings/checkdevtags as @p if predicate sacrilege:offerings/sculk/repulsive run tag @e[tag=altar,limit=1,sort=nearest] add repulsive
execute as @e[tag=altar,limit=1,sort=nearest] if entity @s[tag=sculk] unless predicate sacrilege:offerings/checkdevtags as @p if predicate sacrilege:offerings/sculk/undesirable run tag @e[tag=altar,limit=1,sort=nearest] add undesirable
execute as @e[tag=altar,limit=1,sort=nearest] if entity @s[tag=sculk] unless predicate sacrilege:offerings/checkdevtags as @p if predicate sacrilege:offerings/sculk/mediocre run tag @e[tag=altar,limit=1,sort=nearest] add mediocre
execute as @e[tag=altar,limit=1,sort=nearest] if entity @s[tag=sculk] unless predicate sacrilege:offerings/checkdevtags as @p if predicate sacrilege:offerings/sculk/prodigious run tag @e[tag=altar,limit=1,sort=nearest] add prodigious
execute as @e[tag=altar,limit=1,sort=nearest] if entity @s[tag=sculk] unless predicate sacrilege:offerings/checkdevtags as @p if predicate sacrilege:offerings/sculk/consummate run tag @e[tag=altar,limit=1,sort=nearest] add consummate

item replace entity @p weapon.mainhand with minecraft:air
particle minecraft:sonic_boom ~ ~1 ~ 0 0 0 0 1
playsound minecraft:block.end_portal_frame.fill block @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.respawn_anchor.charge block @a[distance=..5] ~ ~ ~ 5 0.8
tag @e[tag=altar,limit=1,sort=nearest] add offering
scoreboard players set @e[tag=altar,limit=1,sort=nearest] sacri.altarVerdictTimer 10