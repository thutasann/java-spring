type FormDataValue = string | File

/** Append Form Data */
export const appendFormData = <T extends Record<string, FormDataValue>>(
  data: T,
  formData: FormData = new FormData(),
): FormData => {
  for (const key in data) {
    // eslint-disable-next-line no-prototype-builtins
    if (data.hasOwnProperty(key)) {
      const value = data[key]
      if (value instanceof File) {
        formData.append(key, value)
      } else {
        formData.append(key, value as string)
      }
    }
  }
  return formData
}

/** Get FormData's Keys and Values */
export const getFormDataObject = (formData: FormData) => Object.fromEntries(formData.entries())
