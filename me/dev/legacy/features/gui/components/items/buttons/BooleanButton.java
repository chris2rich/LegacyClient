package me.dev.legacy.features.gui.components.items.buttons;

import me.dev.legacy.Client;
import me.dev.legacy.features.gui.OyVeyGui;
import me.dev.legacy.features.modules.client.ClickGui;
import me.dev.legacy.features.setting.Setting;
import me.dev.legacy.util.RenderUtil;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.SoundEvents;

public class BooleanButton extends Button {
   private final Setting setting;

   public BooleanButton(Setting setting) {
      super(setting.getName());
      this.setting = setting;
      this.width = 15;
   }

   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
      RenderUtil.drawRect(this.x, this.y, this.x + (float)this.width + 7.4F, this.y + (float)this.height - 0.5F, this.getState() ? (!this.isHovering(mouseX, mouseY) ? Client.colorManager.getColorWithAlpha((Integer)((ClickGui)Client.moduleManager.getModuleByClass(ClickGui.class)).hoverAlpha.getValue()) : Client.colorManager.getColorWithAlpha((Integer)((ClickGui)Client.moduleManager.getModuleByClass(ClickGui.class)).alpha.getValue())) : (!this.isHovering(mouseX, mouseY) ? 290805077 : -2007673515));
      Client.textManager.drawStringWithShadow(this.getName(), this.x + 2.3F, this.y - 1.7F - (float)OyVeyGui.getClickGui().getTextOffset(), this.getState() ? -1 : -5592406);
   }

   public void update() {
      this.setHidden(!this.setting.isVisible());
   }

   public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
      super.mouseClicked(mouseX, mouseY, mouseButton);
      if (this.isHovering(mouseX, mouseY)) {
         mc.func_147118_V().func_147682_a(PositionedSoundRecord.func_184371_a(SoundEvents.field_187909_gi, 1.0F));
      }

   }

   public int getHeight() {
      return 14;
   }

   public void toggle() {
      this.setting.setValue(!(Boolean)this.setting.getValue());
   }

   public boolean getState() {
      return (Boolean)this.setting.getValue();
   }
}
