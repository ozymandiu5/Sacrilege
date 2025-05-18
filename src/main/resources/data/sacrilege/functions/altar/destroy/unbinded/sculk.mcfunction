loot replace entity @s weapon.mainhand loot sacrilege:random/altar/itemthrow
execute if data entity @s {HandItems:[{tag:{Tag:n}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[0.0d,0.1d,-0.05d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:e}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[0.05d,0.1d,0.0d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:s}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[0.0d,0.1d,0.05d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:w}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[-0.05d,0.1d,0.0d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:ne}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[0.05d,0.1d,-0.05d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:nw}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[-0.05d,0.1d,-0.05d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:se}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[0.05d,0.1d,0.05d],PickupDelay:20s}
execute if data entity @s {HandItems:[{tag:{Tag:sw}}]} run summon item ~ ~1 ~ {Item:{id:"sacrilege:altar",Count:1b},Motion:[-0.05d,0.1d,0.05d],PickupDelay:20s}
execute store result entity @e[type=item,limit=1,sort=nearest] Item.tag.altarType int 1 run data get entity @s ArmorItems[3].tag.altarType
setblock ~ ~ ~ air destroy
kill @e[type=item,nbt={Item:{id:"minecraft:polished_deepslate_wall"}},limit=1,sort=nearest]
kill @s