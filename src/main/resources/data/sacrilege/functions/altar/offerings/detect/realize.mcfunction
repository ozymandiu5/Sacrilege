scoreboard players remove @s sacri.altarVerdictTimer 1
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{tag:{display:{Name:'{"text":"How do I prove it"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add howdoiproveit
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"0zymandiu5"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add 0zymandiu5
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"ExistingEevee"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add ExistingEevee
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Sweebow"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Sweebow
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Lightigivhi"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Lightigivhi
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Termineitron"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Termineitron
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"DanieloXXelo"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add DanieloXXelo
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"minecraft:skeleton_skull",tag:{display:{Name:'{"text":"Modrome"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add Modrome
execute as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{tag:{display:{Name:'{"text":"sweeping"}'}}}} run tag @e[tag=altar,limit=1,sort=nearest] add sweeping
execute if entity @s[tag=sculk] as @e[tag=altarItem,limit=1,sort=nearest] if data entity @s {item:{id:"sacrilege:sculk_altar"}} run tag @e[tag=altar,limit=1,sort=nearest] add fartar
execute unless predicate sacrilege:offerings/checktags run particle minecraft:dust 0 0 0 2 ~ ~1.2 ~ 0.3 0.2 0.3 0 20
execute unless predicate sacrilege:offerings/checktags run playsound minecraft:entity.wither.hurt block @a[distance=..5] ~ ~ ~ 10 0.5
execute if entity @s[tag=sculk] unless predicate sacrilege:offerings/checktags as @p[tag=sculkbinded] run advancement grant @s only sacrilege:altars/reject 
execute unless predicate sacrilege:offerings/checktags run tag @s remove offering
execute if predicate sacrilege:offerings/checktags as @e[tag=altarItem,limit=1,sort=nearest] run data modify entity @s item.id set value air
execute if predicate sacrilege:offerings/checktags run particle minecraft:sculk_charge_pop ~ ~1 ~ 0 0.3 0 0.1 50
execute if predicate sacrilege:offerings/checktags run particle minecraft:end_rod ~ ~1 ~ 0 0.3 0 0.1 20
execute if predicate sacrilege:offerings/checktags run particle minecraft:soul ~ ~1 ~ 0.3 0.3 0.3 0.1 20
execute if predicate sacrilege:offerings/checktags run particle minecraft:enchant ~ ~1.7 ~ 0 0 0 2 100
execute if predicate sacrilege:offerings/checktags run playsound minecraft:block.respawn_anchor.set_spawn block @a[distance=..5] ~ ~ ~ 10 0.8
execute if predicate sacrilege:offerings/checktags run playsound minecraft:block.enchantment_table.use block @a[distance=..5] ~ ~ ~ 10 0.5