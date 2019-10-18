<h1>Envoi d'email</h1>
<form action="email" method="post">
	<input type="hidden" name="action" value="emptyEmail" />
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				Envoyez un email à
			</td>
			<td>
				<input name="recipient" type="text" size="35" placholder="Destinataire" />
			</td>
		</tr>
		<tr>
			<td>
				Depuis 
			</td>
			<td>
				<input name="sender" type="text" size="35" placeholder="Expéditeur" />
			</td>
		</tr>
		<tr>
			<td>
				Sujet
			</td>
			<td>
				<input name="subject" type="text" size="25" placeholder="Sujet de l'email" />
			</td>
		</tr> 
		<tr>
			<td>
				Contenu
			</td>
			<td>
				<textarea row="5" cols="40" name="html_content" placeholder="Texte HTML à envoyer"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Envoyer" />
			</td>
		</tr>
	</table>
</form>
<br /><br />
<hr />
<br />
<h1>Envoi d'email avec pièce(s) jointe(s)</h1>
<form action="email" method="post">
	<input type="hidden" name="action" value="withAttachmentEmail" />
	<table border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>
				Envoyez un email à
			</td>
			<td>
				<input name="recipient" type="text" size="35" placholder="Destinataire" />
			</td>
		</tr>
		<tr>
			<td>
				Depuis 
			</td>
			<td>
				<input name="sender" type="text" size="35" placeholder="Expéditeur" />
			</td>
		</tr>
		<tr>
			<td>
				Sujet
			</td>
			<td>
				<input name="subject" type="text" size="25" placeholder="Sujet de l'email" />
			</td>
		</tr> 
		<tr>
			<td>
				Contenu
			</td>
			<td>
				<textarea row="5" cols="40" name="html_content" placeholder="Texte HTML à envoyer"></textarea>
			</td>
		</tr>
		<!-- 
		<tr>
			<td>
				Pièce jointe
			</td>
			<td>
				<input  type="file" name="file" id="file" size="40"/>
			</td> 
		</tr>
		!-->
		<tr>
			<td colspan="2">
				<input type="submit" value="Envoyer" />
			</td>
		</tr>
	</table>
</form>