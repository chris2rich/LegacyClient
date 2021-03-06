package me.dev.legacy.features.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.dev.legacy.Client;
import me.dev.legacy.features.command.Command;
import me.dev.legacy.features.modules.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import org.lwjgl.input.Mouse;

public class MCF extends Module {
   private boolean clicked = false;

   public MCF() {
      super("MCF", "Middleclick Friends.", Module.Category.MISC, true, false, false);
   }

   public void onUpdate() {
      if (Mouse.isButtonDown(2)) {
         if (!this.clicked && mc.field_71462_r == null) {
            this.onClick();
         }

         this.clicked = true;
      } else {
         this.clicked = false;
      }

   }

   private void onClick() {
      RayTraceResult result = mc.field_71476_x;
      Entity entity;
      if (result != null && result.field_72313_a == Type.ENTITY && (entity = result.field_72308_g) instanceof EntityPlayer) {
         if (Client.friendManager.isFriend(entity.func_70005_c_())) {
            Client.friendManager.removeFriend(entity.func_70005_c_());
            Command.sendMessage(ChatFormatting.RED + entity.func_70005_c_() + ChatFormatting.RED + " has been unfriended.");
         } else {
            Client.friendManager.addFriend(entity.func_70005_c_());
            Command.sendMessage(ChatFormatting.AQUA + entity.func_70005_c_() + ChatFormatting.AQUA + " has been friended.");
         }
      }

      this.clicked = true;
   }
}
