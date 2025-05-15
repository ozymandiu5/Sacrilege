data modify entity @e[tag=altarItem,limit=1,sort=nearest] item set value {id:"minecraft:player_head",Count:1b,tag:{display:{Lore:['{"text":"WARNING: LOUD","color":"dark_red","bold":true,"italic":true}']},SculkDeityItem:1b,AttributeModifiers:[{AttributeName:"generic.knockback_resistance",Name:"generic.knockback_resistance",Amount:0.1,Operation:0,UUID:[I;-1200483427,1909409823,-1253922355,863187370],Slot:"head"},{AttributeName:"generic.armor_toughness",Name:"generic.armor_toughness",Amount:3,Operation:0,UUID:[I;993560074,130303347,-1212636213,787104382],Slot:"head"},{AttributeName:"generic.armor",Name:"generic.armor",Amount:3,Operation:0,UUID:[I;-633484403,1351437197,-1327919969,-1367723787],Slot:"head"}],SkullOwner:"Sweebow",BlockEntityTag:{note_block_sound:"sacrilege:devs.sweebow"}}}
particle minecraft:sonic_boom ~ ~1.3 ~ 0 0 0 0 1
particle minecraft:dust 0 0 0 1 ~ ~1.3 ~ 0.5 0.5 0.5 2 100
particle minecraft:end_rod ~ ~1.3 ~ 0 0 0 0.2 20
playsound minecraft:entity.illusioner.cast_spell block @a[distance=..5] ~ ~ ~ 10 0.5
playsound minecraft:block.ender_chest.open block @a[distance=..5] ~ ~ ~ 10 0.5
advancement grant @p only sacrilege:altars/offering