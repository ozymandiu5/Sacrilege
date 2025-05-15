function sacrilege:altar/place/setlevel

execute at @s run setblock ~ ~ ~ minecraft:polished_deepslate_wall
execute at @s run tp @s ~ ~ ~ facing entity @p

function sacrilege:altar/place/setrot

execute at @s run summon item_display ~ ~ ~ {Tags:["altarItem"],Rotation:[0f,67.5f],transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0.35f,-1.13f],scale:[0.4f,0.4f,0.4f]},item:{id:"minecraft:air",Count:1b}}
execute at @e[tag=altar,tag=!place] as @e[tag=altarItem,limit=1,sort=nearest] run function sacrilege:altar/place/setaltaritem

execute at @s run summon minecraft:interaction ~ ~ ~ {width:1.0f,height:1.5f,Tags:["altarClicks"]}

execute if entity @s[tag=sculk] at @s run summon text_display ~ ~ ~ {Tags:["altarText"],billboard:"vertical",text:'{"text":"Right click to Bind","color":"dark_aqua","bold":true,"italic":false}',transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,1.5f,0f],scale:[1f,1f,1f]}}
execute if entity @s[tag=sculk] at @s run summon item_display ~ ~ ~ {Tags:["altarDisplay","sculk"],transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0.03f,0.51f,0.03f],scale:[0f,0f,0f]},item:{id:"minecraft:scute",Count:1b,tag:{CustomModelData:81513}}}

scoreboard players set @s sacri.altarBinding 0
scoreboard players set @s sacri.altarUnbinding 0
scoreboard players set @s sacri.altarBindCooldown 0
scoreboard players set @s sacri.altarLevel 0
tag @s add place