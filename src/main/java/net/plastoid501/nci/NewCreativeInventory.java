/*
 * This file is part of the New Creative Inventory project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  Plastoid501 and contributors
 *
 * New Creative Inventory is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * New Creative Inventory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with New Creative Inventory.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.plastoid501.nci;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

//#if MC <= 11605
//$$ import org.apache.logging.log4j.LogManager;
//$$ import org.apache.logging.log4j.Logger;
//#else
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//#endif

public class NewCreativeInventory implements ModInitializer
{
	public static final Logger LOGGER =
			//#if MC <= 11605
			//$$ LogManager.getLogger("new-creative-inventory");
			//#else
			LoggerFactory.getLogger("new-creative-inventory");
			//#endif

	public static final String MOD_ID = "new-creative-inventory";
	public static String MOD_VERSION = "1.1.2";
	public static String MOD_NAME = "New Creative Inventory";

	@Override
	public void onInitialize()
	{
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata();
		MOD_NAME = metadata.getName();
		MOD_VERSION = metadata.getVersion().getFriendlyString();
	}
}
