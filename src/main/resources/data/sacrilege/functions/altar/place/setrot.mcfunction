execute store result score @s sacri.altarRot run data get entity @s Rotation[0]
execute if score @s sacri.altarRot matches 0..44 run data modify entity @s Rotation[0] set value 0f
execute if score @s sacri.altarRot matches 45..134 run data modify entity @s Rotation[0] set value 90f
execute if score @s sacri.altarRot matches 135..224 run data modify entity @s Rotation[0] set value 180f
execute if score @s sacri.altarRot matches 225..314 run data modify entity @s Rotation[0] set value 270f
execute if score @s sacri.altarRot matches 315..360 run data modify entity @s Rotation[0] set value 0f
execute if score @s sacri.altarRot matches -360..-314 run data modify entity @s Rotation[0] set value 0f
execute if score @s sacri.altarRot matches -315..-224 run data modify entity @s Rotation[0] set value 90f
execute if score @s sacri.altarRot matches -225..-134 run data modify entity @s Rotation[0] set value 180f
execute if score @s sacri.altarRot matches -135..-44 run data modify entity @s Rotation[0] set value 270f
execute if score @s sacri.altarRot matches -45..0 run data modify entity @s Rotation[0] set value 0f