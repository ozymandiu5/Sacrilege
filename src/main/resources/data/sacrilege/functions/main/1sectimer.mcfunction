execute as @a if score @s sacri.eastereggs.howdoiproveit matches 0.. run scoreboard players add @s sacri.eastereggs.howdoiproveit 1
execute as @e[tag=altar,tag=offering] if score @s sacri.altarVerdictTimer matches 1.. run scoreboard players remove @s sacri.altarVerdictTimer 1
execute as @e[tag=altar] if score @s sacri.altarUnbindingTimer matches 1.. run scoreboard players remove @s sacri.altarUnbindingTimer 1
execute as @e[tag=altar] if score @s sacri.altarBindCooldown matches 1.. run scoreboard players remove @s sacri.altarBindCooldown 1
execute as @e[tag=reality] if score @s sacri.altarLivingTimer matches 1.. run scoreboard players remove @s sacri.altarLivingTimer 1
execute as @a if score @s sacri.altarLivingTimer matches 1.. run scoreboard players remove @s sacri.altarLivingTimer 1
execute as @e[tag=altar] if score @s sacri.altarLivingTimer matches 0.. run scoreboard players add @s sacri.altarLivingTimer 1
schedule function sacrilege:main/1sectimer 1s replace