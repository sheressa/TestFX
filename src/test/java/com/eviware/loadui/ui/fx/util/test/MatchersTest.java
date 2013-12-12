/*
 * Copyright 2013 SmartBear Software
 * 
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the Licence for the specific language governing permissions and limitations
 * under the Licence.
 */
package com.eviware.loadui.ui.fx.util.test;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.TextFieldBuilder;
import javafx.scene.layout.VBoxBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;

import static org.junit.Assert.assertThat;
import static org.loadui.testfx.Matchers.hasText;

@Category( TestFX.class )
public class MatchersTest extends GuiTest
{
	@Override
	protected Parent getRootNode()
	{
		return VBoxBuilder
				.create()
				.children( ButtonBuilder.create().id( "button1" ).text( "Btn A" ).build(),
						ButtonBuilder.create().id( "button2" ).text( "Btn B" ).build(),
						TextFieldBuilder.create().id( "text" ).build() ).build();
	}

	@Test
	public void shouldTypeString()
	{
		final String text = "H3llo Wurl";

		click( "#text" ).type( text );

		assertThat( "#text", hasText( text ) );
	}

	@Test
	public void shouldClickButton()
	{
		final Button button = find( "#button1" );
		button.setOnAction( new EventHandler<ActionEvent>()
		{
			@Override
			public void handle( ActionEvent actionEvent )
			{
				button.setText( "Was clicked" );
			}
		} );

		click( "Btn A" );

		assertThat( "#button1", hasText( "Was clicked" ) );
	}
}