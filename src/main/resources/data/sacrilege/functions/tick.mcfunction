execute as @a store result score @s sacri.YPos run data get entity @s Pos[1]
execute as @a store result score @s sacri.altarCultAdd run data get entity @s UUID[0]
execute as @a in minecraft:overworld unless entity @s[tag=expurgated] if score @s sacri.YPos matches ..-128 run function sacrilege:main/void_death
execute as @e[tag=expurgated] at @s run function sacrilege:main/expurgation
execute in sacrilege:expurgation run kill @e[type=minecraft:experience_orb,distance=0..]

execute as @e[tag=altarClicks] at @s if data entity @s attack as @e[tag=altar,limit=1,sort=nearest] at @s run function sacrilege:main/detect_leftclick

execute as @e[tag=altarClicks] at @s if data entity @s interaction as @e[tag=altar,limit=1,sort=nearest] run function sacrilege:main/detect_rightclick

execute as @e[tag=altar,tag=!place] run function sacrilege:altar/place/place
execute as @e[tag=altar,tag=place] at @s run kill @e[type=item,nbt={Item:{id:"minecraft:polished_deepslate_wall"}},limit=1,sort=nearest,distance=..0.5]
execute as @e[tag=altar,tag=place] at @s unless block ~ ~ ~ minecraft:polished_deepslate_wall run setblock ~ ~ ~ minecraft:polished_deepslate_wall destroy
execute as @e[tag=altarDisplay] at @s unless entity @e[tag=altar,limit=1,sort=nearest,distance=..0.1] run kill @s
execute as @e[tag=altarItem] at @s unless entity @e[tag=altar,limit=1,sort=nearest,distance=..0.3] run kill @s
execute as @e[tag=altarClicks] at @s unless entity @e[tag=altar,limit=1,sort=nearest,distance=..0.3] run kill @s
execute as @e[tag=altarText] at @s unless entity @e[tag=altar,limit=1,sort=nearest,distance=..0.5] run kill @s

execute as @e[tag=altarDisplay] run scoreboard players add @s sacri.altarCircle 1
execute as @e[tag=altarDisplay] store result entity @s Rotation[0] float 1 run scoreboard players get @s sacri.altarCircle
execute as @e[tag=altar] run data modify entity @s Rotation[1] set value 0
execute as @e[tag=altarDisplay] at @s run function sacrilege:main/altarcircle_leveling
execute as @e[tag=altar] at @s if score @s sacri.altarVerdictTimer matches 6 run function sacrilege:altar/offerings/detect/realize
execute as @e[tag=altar] at @s if score @s sacri.altarVerdictTimer matches 0 run function sacrilege:altar/offerings/detect/verdict
execute as @a at @s if score @s sacri.eastereggs.howdoiproveit matches 6.. run function sacrilege:altar/offerings/eastereggs/howdoiproveit/2
execute as @e[tag=altar] if score @s sacri.altarUnbindingTimer matches 0 run scoreboard players set @s sacri.altarUnbinding 0

execute as @e[tag=reality] at @s if score @s sacri.altarLivingTimer matches 1.. run function sacrilege:main/realitytick
execute as @e[tag=reality] at @s if score @s sacri.altarLivingTimer matches 0 run function sacrilege:main/realitycrystalize

execute as @e[type=minecraft:armor_stand,tag=!altar] if data entity @s {ArmorItems:[{id:"sacrilege:altar",tag:{altarType:1}}]} run tag @s add sculk
execute as @e[type=minecraft:armor_stand,tag=!altar] if data entity @s {ArmorItems:[{id:"sacrilege:altar"}]} run tag @s add altar