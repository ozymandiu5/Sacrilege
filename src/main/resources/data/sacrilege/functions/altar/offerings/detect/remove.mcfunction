summon item ~ ~1.5 ~ {Tags:["itemToGive"],Item:{id:"minecraft:scute",Count:1b}}
data modify entity @e[tag=itemToGive,limit=1,sort=nearest] Item set from entity @e[tag=altarItem,limit=1,sort=nearest] item
data modify entity @e[tag=altarItem,limit=1,sort=nearest] item.id set value air
playsound minecraft:item.bundle.remove_one block @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.deepslate.step block @a[distance=..5] ~ ~ ~ 10 0.5